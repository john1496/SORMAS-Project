
#*******************************************************************************
# SORMAS® - Surveillance Outbreak Response Management & Analysis System
# Copyright © 2016-2018 Helmholtz-Zentrum f�r Infektionsforschung GmbH (HZI)
#
# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# This program is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <https://www.gnu.org/licenses/>.
#*******************************************************************************

#!/bin/bash

echo "# SORMAS NEW CERTIFICATE GENERATION"
echo "# This script generate a new self signed certificate, to be used for SORMAS2SORMAS and SurvNet communication"
echo "# If anything goes wrong, please consult the certificate creation guide or get in touch with the developers."

if [[ $(expr substr "$(uname -a)" 1 5) = "Linux" ]]; then
	LINUX=true
else
	LINUX=false
fi

while [[ -z "${SORMAS_S2S_CERT_PASS}" ]]; do
  read -p "Please provide a password for the certificate:'${SORMAS_S2S_CERT_PASS}': " SORMAS_S2S_CERT_PASS
done

while [[ -z "${SORMAS_S2S_CERT_CN}" ]]; do
  read -p "Please provide a Common Name (CN) for the certificate:'${SORMAS_S2S_CERT_CN}': " SORMAS_S2S_CERT_CN
done

while [[ -z "${SORMAS_S2S_CERT_ORG}" ]]; do
  read -p "Please provide an Organization (O) for the certificate:'${SORMAS_S2S_CERT_ORG}': " SORMAS_S2S_CERT_ORG
done

read -p "Hehe. Press [Enter] to continue or [Ctrl+C] to cancel."
